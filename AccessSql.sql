


select id,label,amperage,voltage,price*util as totale,
int((iif(label='Panneaux solaire',10000/([voltage]*[amperage]),iif(label='baterie',5000/([voltage]*[amperage]))))+0.99) as util
from produit
