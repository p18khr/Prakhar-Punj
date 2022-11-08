#!/usr/bin/env python
# coding: utf-8

# ### import numpy as np
# import pandas as pd
# import matplotlib.pyplot as plt
# from sklearn.linear_model import LinearRegression
# import seaborn as sns
# sns.set()

# In[1]:


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression 
import seaborn as sns
sns.set()


# In[2]:


raw_data = pd.read_csv(r'C:\Users\prakh\Downloads\1.04.+Real-life+example.csv')


# In[3]:


raw_data


# In[4]:


raw_data.describe(include = 'all')


# # determining the values of interest

# In[5]:


data = raw_data.drop(['Model'],axis = 1)


# In[6]:


data.describe(include = 'all')


# # missing values

# In[7]:


data.isnull().sum() # finds the null fields


# In[8]:


data_no_mv = data.dropna(axis = 0) # mv stands for missing values


# In[9]:


data_no_mv.isnull().sum()


# In[10]:


data_no_mv.describe(include = 'all')


# # Exploring the probability distribution functions

# In[11]:


sns.distplot(data_no_mv['Price'])


# # Dealing with outliers

# In[12]:


q = data_no_mv['Price'].quantile(0.99)
q


# In[13]:


data_no_mv = data_no_mv[data_no_mv['Price'] < q]
data_no_mv.describe(include = 'all')


# In[14]:


sns.distplot(data_no_mv['Price'])


# In[15]:


sns.distplot(data_no_mv['Mileage'])


# In[16]:


q1 = data_no_mv['Mileage'].quantile(0.99)
data_no_mv = data_no_mv[data_no_mv['Mileage'] < q1]


# In[17]:


sns.distplot(data_no_mv['Mileage'])


# In[18]:


sns.distplot(data_no_mv['EngineV'])


# In[19]:


data_no_mv = data_no_mv[data_no_mv['EngineV'] < 6.5]


# In[20]:


sns.distplot(data_no_mv['EngineV'])


# In[21]:


sns.distplot(data_no_mv['Year'])


# In[22]:


q = data_no_mv['Year'].quantile(0.01)
data_no_mv= data_no_mv[data_no_mv['Year'] > q]


# In[23]:


sns.distplot(data_no_mv['Year'])


# In[24]:


data_cleaned = data_no_mv.reset_index(drop = True) # drop = True drops the original indexes of the table


# In[25]:


data_cleaned.describe(include = 'all')


# # checking the OLS assumptions

# In[26]:


f, (ax1,ax2,ax3) = plt.subplots(1,3,sharey = True,figsize = (15,3))
ax1.scatter(data_cleaned['Year'],data_cleaned['Price'])
ax1.set_title('Price and year')
ax2.scatter(data_cleaned['EngineV'],data_cleaned['Price'])
ax2.set_title('Price and EngineV')
ax3.scatter(data_cleaned['Mileage'],data_cleaned['Price'])
ax3.set_title('Price and Mileage')

plt.show()


# In[27]:


sns.distplot(data_cleaned['Price'])


# In[28]:


log_price = np.log(data_cleaned['Price'])
data_cleaned['log_price'] = log_price


# In[29]:


f, (ax1,ax2,ax3) = plt.subplots(1,3,sharey = True, figsize = (20,3))
ax1.scatter(data_cleaned['Year'],data_cleaned['log_price'])
ax1.set_title('Log-Price and Year')
ax2.scatter(data_cleaned['EngineV'],data_cleaned['log_price'])
ax2.set_title('Log-Price and EngineV')
ax3.scatter(data_cleaned['Mileage'],data_cleaned['log_price'])
ax3.set_title('Log-Price and Mileage')
plt.show()


# In[30]:


data_cleaned = data_cleaned.drop(['Price'],axis =1)


# In[31]:


data_cleaned


# In[32]:


data_cleaned.columns.values  # array of column names


# In[33]:


from statsmodels.stats.outliers_influence import variance_inflation_factor


# In[34]:


variables = data_cleaned[['Mileage','Year','EngineV']]
vif = pd.DataFrame()


# # vif or variance inflation factor is used to attain no multicollinearity rule

# In[35]:


vif["VIF"] = [variance_inflation_factor(variables.values,i) for i in range(len(variables.columns))] # variables.values refers to the values of all columns of 'variables'
vif["Features"] = variables.columns


# In[36]:


vif


# In[37]:


data_no_multicoll = data_cleaned.drop(['Year'],axis=1)


# In[38]:


data_with_dummies = pd.get_dummies(data_no_multicoll,drop_first = True)


# In[39]:


data_with_dummies


# # Rearraning

# In[40]:


data_with_dummies.columns


# In[41]:


cols = ['log_price','Mileage', 'EngineV', 'Brand_BMW', 'Brand_Mercedes-Benz',
       'Brand_Mitsubishi', 'Brand_Renault', 'Brand_Toyota', 'Brand_Volkswagen',
       'Body_hatch', 'Body_other', 'Body_sedan', 'Body_vagon', 'Body_van',
       'Engine Type_Gas', 'Engine Type_Other', 'Engine Type_Petrol',
       'Registration_yes']


# In[42]:


data_preprocessed = data_with_dummies[cols]


# In[43]:


data_preprocessed


# # Linear regression model

# In[44]:


targets = data_preprocessed['log_price']
inputs = data_preprocessed.drop(['log_price'],axis = 1)


# In[45]:


from sklearn.preprocessing import StandardScaler


# In[46]:


scaler = StandardScaler()


# In[47]:


scaler.fit(inputs)


# In[48]:


inputs_scaled = scaler.transform(inputs)


# # train test split

# In[49]:


from sklearn.model_selection import train_test_split


# In[50]:


x_train , x_test , y_train , y_test = train_test_split(inputs_scaled , targets , test_size = 0.2 , random_state = 365)


# # creating regression

# In[51]:


reg = LinearRegression()


# In[52]:


reg.fit(x_train , y_train)


# In[53]:


y_hat = reg.predict(x_train)


# # here y_train is the log_price which is actually the price of the car while with y_hat is the predicted price and here we are comparing the price predicted abd the actual one 

# In[54]:


plt.scatter(y_train,y_hat)  
plt.xlabel('y_train',fontsize=20)
plt.ylabel('y_hat',fontsize =20)
plt.xlim(6,13)
plt.ylim(6,13)
x = np.arange(0,13)
y=x
plt.plot(x,y, c ='orange' , lw = 7)


# In[55]:


sns.distplot(y_train - y_hat)
plt.title('Residuals PDF' , size = 18)


# In[56]:


reg.score(x_train , y_train) #R squared


# # Weights and Bias

# In[57]:


reg_summary = pd.DataFrame(inputs.columns , columns = ['Features'])
reg_summary['Weights'] = reg.coef_


# In[58]:


reg_summary


# In[59]:


data_cleaned['Brand'].unique()


# # Testing

# In[60]:


y_hat_test = reg.predict(x_test)


# In[61]:


y_hat_test.shape


# In[62]:


plt.scatter(y_test,y_hat_test , alpha = 0.2)
plt.xlabel('y_test',fontsize = 20)
plt.ylabel('y_hat_test',fontsize = 20)
plt.xlim(7,12)
plt.ylim(7,12)


# In[63]:


df_pf = pd.DataFrame(np.exp(y_hat_test) , columns = ['Predictions'])


# In[64]:


df_pf


# In[65]:


df_pf['Target'] = np.exp(y_test)


# In[66]:


df_pf


# In[67]:


y_test # old indexing is preserved so we will have to reset the indices


# In[68]:


y_test = y_test.reset_index(drop = True)


# In[69]:


df_pf['Target'] = np.exp(y_test)


# In[70]:


df_pf


# In[71]:


df_pf['Residuals'] = df_pf['Predictions'] - df_pf['Target']


# In[72]:


df_pf


# In[73]:


df_pf['Difference %'] = (df_pf['Target'] / df_pf [ 'Predictions'])*100


# In[74]:


df_pf


# In[75]:


df_pf.describe()


# In[ ]:




