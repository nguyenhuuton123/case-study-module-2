from gtts import gTTS
import os
from playsound import playsound
import sys
tts = gTTS("Xin chào " + sys.argv[1] + " chào mừng bạn đã đến với hệ thống của chúng tôi",tld='com.vn',lang='vi')

tts.save("hello.mp3")
playsound("hello.mp3")