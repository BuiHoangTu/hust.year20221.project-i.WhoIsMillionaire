

CREATE TABLE "Questions" (
    "QID" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "Question" varchar(1000),
    "RightAnswer" varchar(100), 
    "WrongAnswer1" varchar(100),
    "WrongAnswer2" varchar(100),
    "WrongAnswer3" varchar(100),
    "QLevel" INTEGER NOT NULL,
    UNIQUE ("Question", "RightAnswer")
) ;

CREATE TABLE "Users"   (
    UID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    Name varchar(100) NOT NULL,
    Passwd varchar(100) NOT NULL,
    Score INTEGER DEFAULT NULL,
    Date datetime DEFAULT current_timestamp,
    UNIQUE(Name)
) ;
CREATE INDEX ixHighScore on Users (Score );




