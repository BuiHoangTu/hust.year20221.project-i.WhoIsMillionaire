
# Project I
## Sub-project store questions

This sub-project supports `Ai là Triệu phú` video game, it is used to add more questions to game's database



## Authors

- [Bùi Hoàng Tú](https://github.com/BuiHoangTu)

## Manual

Use ProcessQuestionForProjectI with [python3](https://www.python.org/downloads/)

### Install python3
For Debian-base distro :
```bash
sudo apt install python3
```
or follow instructions in [python main page](https://www.python.org/)

### Sources preparation 
1. Make sure all your files is in excel format
2. Put all those files in "InputExcel/"
3. Insert questions
    * Use python virtual environment
        * For Mac OS / Linux
        ```bash
        source ./PyContainer/bin/activate   
        ```
        * For Windows
        ```bash
        .\PyContainer\Scripts\activate
        ```
    * Run script
        ```bash
        ./PyContainer/bin/python ./PyContainer/src/main.py
        ```