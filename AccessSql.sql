


select id,label,amperage,voltage,price*util as totale,
int((iif(label='Panneaux solaire',10000/([voltage]*[amperage]),iif(label='baterie',5000/([voltage]*[amperage]))))+0.99) as util
from produit

select id,min(puissanceTotal) from
(select id,label,util*[voltage]*[amperage] as puissanceTotal 
from  (select id,label,amperage,voltage,price,int((iif(label='Panneaux solaire',-int(-80/([voltage]*[amperage])),iif(label='baterie',-int(-0/([voltage]*[amperage])),0)))) as util
from produit)as tab1
group by label

select tab1.*, util*[voltage]*[amperage] as puissanceTotal,price*util as pricetotal from  (select id,label,amperage,voltage,price,
int((iif(label='Panneaux solaire',-int(-80/([voltage]*[amperage])),iif(label='baterie',-int(-0/([voltage]*[amperage])),0)))) as util 
from produit) as tab1
