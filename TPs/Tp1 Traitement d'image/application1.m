boat=imread("boat.png");
boat=im2double(boat);
elaine=imread("elaine.jpg");
elaine=im2double(elaine);

figure (1)
imshow(elaine)

figure (2)
imshow(boat)

boatf=fftshift(fft2(boat));
elainef=fftshift(fft2(elaine));

Bm=abs(boatf);
Em=abs(elainef);
Ba=angle(boatf);
Ea=angle(elainef);

figure (3)
imshow(Ba)

figure(4)
imshow(log(Bm)/max(max(log(Bm))))

boat_fantome=ifft2(Bm.*exp(1i*Ea));

elaine_fantom=ifft2(Em.*exp(1i*Ba));

figure (7)
imshow(boat_fantome)

figure (8)
imshow(elaine_fantom)

Ise=boat(1:2:end,1:2:end);
H=[1 2 1]'*[1 2 1]/16;
If=conv2(boat,H);
Ifs=If(1:2:end,1:2:end);

figure (9)
imshow(Ise)

figure (10)
imshow(Ifs)



