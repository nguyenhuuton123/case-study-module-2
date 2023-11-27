from gtts import gTTS
import os
from playsound import playsound
import sys
tts = gTTS("Đã thêm " + sys.argv[1] + " vào giỏ hàng thành công",tld='com.vn',lang='vi')

tts.save("hello.mp3")
playsound("hello.mp3")
