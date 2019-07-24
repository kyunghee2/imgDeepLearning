import cv2
import numpy as np
import sys

def imgTest(imagePath):    
    gray = cv2.imread(imagePath, cv2.IMREAD_GRAYSCALE)
    gray = cv2.resize(255-gray,(28,28))
    test_img = gray.flatten()/255.0
    test_img = test_img.reshape((-1,28,28,1))

    print(test_img)

imgTest(sys.argv[1])