

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
    CreateDate datetime DEFAULT current_timestamp,
    UNIQUE(Name)
) ;


CREATE TABLE Scores (
    UID INTEGER NOT NULL,
    PlayDate datetime DEFAULT CURRENT_TIMESTAMP,
    
    Score INTEGER DEFAULT 0,
    CONSTRAINT fkUser 
        FOREIGN KEY (UID)
        REFERENCES Users (UID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    PRIMARY KEY (UID, PlayDate)
);
CREATE INDEX idxHighScore on Scores (Score );









