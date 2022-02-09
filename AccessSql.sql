

select id,label,amperage,voltage,
int((iif(label='Panneaux solaire',10000/([voltage]*[amperage]),iif(label='baterie',5000/([voltage]*[amperage]))))+0.99)
from produit
