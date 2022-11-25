import os

import pandas as pd

import mysql
import mysql.connector
from mysql.connector import Error as SQLError

import random


#get connection, cursor
projectIDb = None
try:
    projectIDb = mysql.connector.connect(
        host= "localhost",
        user= "root",
        port= 3306,
        database= "ProjectI"
    )   
    print("DB ready\n")
    cursor = projectIDb.cursor()
except SQLError as e:
    print("DB Error " + e)
cursor = projectIDb.cursor(prepared= True)

#####################################FUNCTION REGION#####################################
def sqlQMap(char : int):
    if (char == 'A') : return 0
    if (char == 'B') : return 1
    if (char == 'C') : return 2
    if (char == 'D') : return 3

qInserted = 0
def sqlInsert(Question : str, AList : list[int], RIndex : int):
    #if(++qInserted >5) : return 
    query = "INSERT INTO ProjectI.Questions(Question, RightAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, QLevel)VALUES(%s, %s, %s, %s, %s, %s);"
    selections = [0,1,2,3]
    selections.remove(RIndex)
    
    selection = random.choice(selections)
    selections.remove(selection)
    WA1 = selection
    
    selection = random.choice(selections)
    selections.remove(selection)
    WA2 = selection

    selection = random.choice(selections)
    selections.remove(selection)
    WA3 = selection

    rparams = (Question,AList[RIndex],AList[WA1], AList[WA2], AList[WA3], str(random.choice([5,10,15])))
    try :
        cursor.execute(query, rparams)
    except SQLError as e:
        if "for key 'U_Question'" in e.args[1] : print ("Question : [[" + Question + "]] is not inserted because it is already inside database")
        else : print(e)
        
#####################################END REGION#####################################


#list all file in InputExcel
inputFolder = "InputExcel"
inputFiles = None
for (root,dirs,files) in os.walk(inputFolder): inputFiles = files

for inputFile in inputFiles :
    #read pdf
    reader = pd.read_excel(inputFolder + "/" + inputFile)
    reader.reset_index()
    for index, row in reader.iterrows(): #index is column number; row is each row
        sqlQ = row[0]
        aA = row[1]
        aB = row[2]
        aC = row[3]
        aD = row[4]
        sqlTrue = sqlQMap(row[5])
        sqlInsert(sqlQ,[aA,aB,aC,aD],sqlTrue)

#save to Db and close connection
projectIDb.commit()
projectIDb.close()



