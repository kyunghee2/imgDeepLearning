import cv2
import numpy as np

#def imgTest(imgpath): 
imgpath = "C:/python_ML/img/7.png"
imgBGR = cv2.imread(imgpath)

img_numpy = np.array(imgBGR, 'uint8')
imgGRAY = cv2.cvtColor(img_numpy, cv2.COLOR_BGR2GRAY)
print(imgGRAY)