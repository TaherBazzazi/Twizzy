% boat=imread("boat.png");
% boat=im2double(boat);
% 
% imhist(boat);
% g=graythresh(boat);
% 
% Ib=zeros(size(boat));
% Ib(boat>g)=1;
% imshow(Ib);


pions=im2double(imread("pions.jpg"));

pionshsv=rgb2hsv(pions);

H=pionshsv(:,:,1);
%figure,imhist(H);

MasqueJ=zeros(size(H));
MasqueJ(H>0.10 & H<0.22)=1;
%figure,imshow(MasqueJ);


SE = strel('disk',9);
MasqueJ1=imerode(MasqueJ,SE);
MasqueJ2=imdilate(MasqueJ1,SE);

figure,imshow(MasqueJ2-MasqueJ1);

pionsJ=pions;
for i=1:3
   pionsJ(:,:,i)=pionsJ(:,:,i).*MasqueJ2;
end
figure,imshow(pionsJ)
