import pandas as pd
from datetime import datetime
import json


#alterar entrada json com historico transacao cliente
with open('message.txt', 'r') as fobj:
    data = json.load(fobj)

#linkar base customerDefault nesta variável

customerDefault = pd.DataFrame({'accountId': '00711234533',
                                'partner': 'Quinto Andar',
                                'amount': -3000,
                                'dueDate': '30/15/2020'},index=[0])

customerDefault['dueDate'] = customerDefault.dueDate.apply(lambda x: datetime.strptime(x, '%d/%m/%Y'))
customerDefault['month'] = customerDefault.dueDate.apply(lambda x: x.month)
customerDefault['year'] = customerDefault.dueDate.apply(lambda x: x.year)



#funçoes criadas
def adjust_amount(df, column_to_adj,column_ref):
    amt_adj = []
    for lin, value in enumerate(df[column_to_adj]):
        if df[column_ref][lin] == 'Debit':
            amt_adj.append((-1)*float(value))
        else:
            amt_adj.append(float(value))
    return pd.concat([df,pd.DataFrame(amt_adj,columns=['amount_adj'])],axis=1)


def gen_default(df, column_to_adj,column_ref, column_balance):
    qtd_default   = []
    for lin, value in enumerate(df[column_to_adj]):
        if (df[column_ref][lin] == 'Debit') and (df[column_balance][lin] < value):
            qtd_default.append(1)            
        else:
            qtd_default.append(0)            
    return pd.concat([df,pd.DataFrame(qtd_default,columns=['qtd_default'])],axis=1)
            



df = pd.DataFrame(data['data']['transaction'])

amt     = pd.DataFrame(df.amount.to_list())
btcode  = pd.DataFrame(df.bankTransactionCode.to_list())
pbtcode = pd.DataFrame(df.proprietaryBankTransactionCode.to_list())
bal     = pd.DataFrame(df.balance.to_list())
bal_    = pd.DataFrame(bal.amount.to_list())
bal_.columns = ['amount_bal','currency_bal']

df.drop(['amount','bankTransactionCode','proprietaryBankTransactionCode','balance','balance'],axis=1,inplace=True)

df = pd.concat([df,amt,btcode,pbtcode,bal.drop(['amount'],axis=1),bal_],axis=1)

df['bookingDateTime'] = df.bookingDateTime.apply(lambda x: datetime.strptime(x, '%Y-%m-%dT%H:%M:%S-%f:00'))
df['month'] = df.bookingDateTime.apply(lambda x: x.month)
df['year'] = df.bookingDateTime.apply(lambda x: x.year)
    
df = adjust_amount(df=df,column_to_adj='amount',column_ref='creditDebitIndicator')

df_income = df[['accountId','year','month','amount_adj']].groupby(by=['accountId','month','year']).sum()

df_income.reset_index(inplace=True)

df_income = df_income.merge(customerDefault[['accountId','month','year','amount']],how='left', on=['accountId','month','year'])

df_income = df_income.fillna(0)

df_income['amountNew'] = df_income.amountAdj + df_income.amount

df_income = df_income.drop(['month','year'],axis=1).groupby('accountId').agg({'amountNew':['mean','std'],'qtdDefault':['sum']})


#output

df_income.to_json('output.json')