clear all 
close all
clc

digitDatasetPath = fullfile('Train');

imds=imageDatastore(digitDatasetPath,"IncludeSubfolders",true,'LabelSource','foldernames');

nbimage=countEachLabel(imds);
size(readimage(imds,1))


% % Now from this point, use the custom reader function
imds.ReadFcn = @customreader;
% % Reset the datastore to the state where no data has been read from it.
reset(imds);

[trainData,valData]=splitEachLabel(imds,0.7,'randomized');

layers = [
 imageInputLayer([30 30 3])
 convolution2dLayer(5,32,'Padding','same')
 batchNormalizationLayer
 reluLayer
convolution2dLayer(5,32,'Padding','same')
 batchNormalizationLayer
 reluLayer
 maxPooling2dLayer(2,'Stride',2)
 dropoutLayer(0.25)
 convolution2dLayer(3,64,'Padding','same')
 batchNormalizationLayer
 reluLayer
convolution2dLayer(3,64,'Padding','same')
 batchNormalizationLayer
 reluLayer
 maxPooling2dLayer(2,'Stride',2)
 dropoutLayer(0.25)

 
 fullyConnectedLayer(43)
 softmaxLayer
 classificationLayer];

options = trainingOptions('sgdm', ...
 'InitialLearnRate',0.01, ...
 'MaxEpochs',5, ...
 'Shuffle','every-epoch', ...
 'ValidationData',valData, ...
 'ValidationFrequency',80, ...
 'Verbose',false, ...
 'Plots','training-progress');

net=trainNetwork(trainData,layers,options);

Pred=classify(net,valData);
ylab=valData.Labels;
accuracy=sum(Pred==ylab)/numel(ylab)

 desired_size = [30, 30];
 im = imread('41.png');     
 im_resized = imresize(im, desired_size);
 classify(net,im_resized)

