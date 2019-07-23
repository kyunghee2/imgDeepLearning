import cv2
import numpy as np

#def imgTest(imgpath): 
imgpath = "C:/Users/student/workspace_python/imgDeepLearning/src/main/webapp/upload/7.png"
imgBGR = cv2.imread(imgpath)

img_numpy = np.array(imgBGR, 'uint8')
imgGRAY = cv2.cvtColor(img_numpy, cv2.COLOR_BGR2GRAY)
print(imgGRAY)