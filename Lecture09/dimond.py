class A:
  def __init__(self):
    self._id:int = 0;
    self.value:double = 0.0;

  def inc(self):
    self.value+=1

class B(A):
  def inc(self):
    self.value+=2

class C(A):
  def inc(self):
    self.value+=5

class D(B,C):
  def printValue(self):
    print("value:",self.value)

d = D()
d.printValue()
d.inc()
d.printValue()

# Method Resolution Order
print(D.__mro__)