import tkinter as tk
from tkinter import messagebox

# Tkinter 기본 윈도우
root = tk.Tk()
# 윈도우 숨기기 (사용자에게 안보이게 끔)
root.withdraw()

# 'showinfo' 함수 사용 알림창 띄움
messagebox.showinfo("알림", "반갑다, 세상아!")
# showwarning, showerror 로 경고, 오류창도 생성 가능
# messagebox.showwarning ("창명", "내용")
# messagebox.showerror ("창명", "내용")

# 유저 창닫기 전 대기
root.mainloop()