# -*- coding: utf-8 -*-
"""06_Deep_CNN

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/17e3h4ZGlFHGXrvg5caScr8gbnQiHl-5q
"""

import torch
import torch.nn as nn
import torchvision
import torchvision.transforms as transforms

import pdb

device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
device

num_epochs = 5
num_classes = 10
batch_size = 100
learning_rate = 0.001

train_dataset=torchvision.datasets.MNIST(root='../../data/',
                                         train = True,
                                         download=True,
                                         transform = transforms.ToTensor())

test_dataset=torchvision.datasets.MNIST(root='../../data/',
                                         train = False,
                                         transform = transforms.ToTensor())

train_loader = torch.utils.data.DataLoader(train_dataset,
                                           batch_size = batch_size,
                                           shuffle = True)

test_loader = torch.utils.data.DataLoader(test_dataset,
                                           batch_size = batch_size,
                                           shuffle = False)

class ConvNet(nn.Module):
  def __init__(self, num_classes=10):
    super(ConvNet, self).__init__()
    #레이어 하나 만들기
    self.layer1 = nn.Sequential(
        nn.Conv2d(1, 16, kernel_size=5, stride=1, padding=2), 
        #입력채널, 출력채널(hidden layer의 필터 개수), 필터 개수
        #원본사이즈, 출력사이즈 동일하게 가져가려면 padding 써야 함. 5x5일 때 stride=1, padding=2
        nn.ReLU())
    self.layer2 = nn.MaxPool2d(kernel_size=2, stride=2)
    self.layer3 = nn.Sequential(
        nn.Conv2d(16, 32, kernel_size=5, stride=1, padding=2), 
        nn.ReLU())
    self.layer4 = nn.MaxPool2d(kernel_size=2, stride=2)
    self.layer5 = nn.Linear(7*7*32, num_classes) #입력, 출력

  def forward(self, x):
    # pdb.set_trace()
    out = self.layer1(x)
    out = self.layer2(out)
    out = self.layer3(out)
    out = self.layer4(out)
    out = out.reshape(out.size(0), -1) #2차원을 1차원으로 펼치는 과정
    out = self.layer5(out)

    return out

model = ConvNet(num_classes).to(device)

loss_function = nn.CrossEntropyLoss()
optimizer = torch.optim.Adam(model.parameters(),lr=learning_rate)

total_step = len(train_loader)
for epoch in range(num_epochs):
  for i,(images,labels) in enumerate(train_loader):
    images = images.to(device)
    labels = labels.to(device)

    # pdb.set_trace()#디버그 하는 코드 #l은 시작하는 자리를 알려주고 q는 디버그 마침

    preds = model(images)
    loss = loss_function(preds,labels)

    optimizer.zero_grad()
    loss.backward()

    optimizer.step()

    if(i+1)%100 == 0:
      print('Epoch [{}/{}], Step [{}/{}], Loss{:.3f}'.format(epoch+1,num_epochs,i+1,total_step,loss.item()))

model.eval()
with torch.no_grad():
  correct =0
  total = 0
  for images, labels  in test_loader:
    images = images.to(device)
    labels = labels.to(device)
    outputs= model(images) # forward 호출

    _,predicted = torch.max(outputs.data,1)
    total += labels.size(0)
    correct += (predicted == labels).sum().item()

  print('Test Accuracy: {}%'.format(100*correct/total))

import matplotlib.pyplot as plt
import numpy as np

images.shape #28*28*1의 이미지가 100개 씩 loading됨
images[0].size()
#첫번째 이미지의 사이즈
images[0,0].size() #맨 앞의 값이 n번째 이미지, n번째 이미지의 사이즈만 반환한다(채널제외하고)
labels

image = np.array(images[0,0].detach().cpu())
label = labels[0].item()
pred = predicted[0].item()
print(label,pred)
plt.imshow(image*255)

for idx in range(30):
  image = np.array(images[idx,0].detach().cpu())
  label = labels[idx].item()
  pred = predicted[idx].item()
  plt.figure(figsize=(2,2))
  plt.title('label: {}, predicted: {}'.format(label,pred))
  plt.imshow(image*255)







