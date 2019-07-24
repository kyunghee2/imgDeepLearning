# import cv2
import sys
import tensorflow as tf
import pandas as pd
import numpy as np
from PIL import Image
import matplotlib.pyplot as plt
from skimage import io, color

def imgTest(imagePath):   
    sess = tf.InteractiveSession()
    new_saver = tf.train.import_meta_graph("./model/dnn.ckpt.meta")
    new_saver.restore(sess, "./model/dnn.ckpt")
    
    tf.get_default_graph()
    
    X = sess.graph.get_tensor_by_name("input:0")
    drop_rate = sess.graph.get_tensor_by_name("drop:0")
    H = sess.graph.get_tensor_by_name("hypothesis:0")
    
    img = Image.open(imagePath)
    img = img.resize((28,28))
    
    img = np.array(img)
    lina_gray = color.rgb2gray(img)
    lina_gray = 1 - lina_gray
   
    plt.imshow(lina_gray, cmap = "Greys", interpolation="nearest")
   
    plt.show()
    
    pix = lina_gray.reshape(-1,784)
    
    result = sess.run(tf.argmax(H,1), 
                     feed_dict={X:pix,drop_rate:1})
    print(result)
    
# def imgTest(imagePath):    
#     gray = cv2.imread(imagePath, cv2.IMREAD_GRAYSCALE)
#     gray = cv2.resize(255-gray,(28,28))
#     test_img = gray.flatten()/255.0
#     test_img = test_img.reshape((-1,28,28,1))
# 
#     print(test_img)

imgTest(sys.argv[1])