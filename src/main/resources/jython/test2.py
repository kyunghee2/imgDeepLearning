import PIL.Image as pilimg
import numpy as np
import matplotlib.pyplot as plt


#def imgTest(imgpath): 
imgpath = "C:/python_ML/img/7.png"
      
im = pilimg.open(imgpath)
 
pix = np.array(im)
    
print(pix.shape)

plt.imshow(pix, cmap="Greys", interpolation="nearest")
plt.show()
