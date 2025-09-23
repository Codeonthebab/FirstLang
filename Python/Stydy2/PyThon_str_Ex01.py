inStr = " 한글 Python 프로그래밍 "
outStr = ""

for i in range (0, len(inStr)):
    if inStr[i] != "":
        outStr += inStr[i]
        
    
    print ("입력받은 문자열 : "+"["+ inStr + "]")
    print ("====================================")
    print ("입력받은 문자열 : "+"["+ outStr + "]")