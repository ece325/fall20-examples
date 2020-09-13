class Element:
  _numElements = 0
  
  def __init__(self):
    Element._numElements += 1
    self.id = Element._numElements

  @classmethod
  def getNumElements(cls):
    return cls._numElements  

if __name__=="__main__":
  # x
  y = Element()
  z = Element()
  print("Number of Elements created:",Element.getNumElements())
  print("Element Id of y:",y.id)