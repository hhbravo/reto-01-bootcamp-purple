# reto-01-bootcamp-purple

Se desarrolló 2 apis rest: Obtener parametría y Simulador de cuota.

## TABLAS 
* CLIENTE

| ID  | DOCUMENTO |
| --- | --------- |
| 1   |  44444444 |
| 2   | 55555555  |

* TARJETA

| ID  | VALOR    |
| --- | -------- |
| 1   | CLASICA  |
| 2   | ORO      |
| 3   | BLACK    |

* CLIENTE TARJETA

| ID  | ID USUARIO   | ID TARJETA |
| --- | ----------   | ---------- | 
| 1   | 1 (44444444) | 1 (CLASICA)|
| 2   | 1 (44444444) | 3 (BLACK)  |
| 3   | 2 (55555555) | 2 (ORO)    |
| 4   | 2 (55555555) | 1 (CLASICA)|

* TEA

| ID  | VALOR    | TASA  |
| --- | -------- |  ---  |
| 1   | 99.90%   | 99.90 |
| 2   | 95.90%   | 95.90 |    
| 3   | 99.00%   | 99.00 |

## Endpoint

* <i>Parametros<i> <br>
URL: http://localhost:8080/configuration <br>
METHOD: GET
  

* <i>Simulador</i> <br>
URL: http://localhost:8080/prestamo
METHOD: POST <br>
- REQUEST-BODY:
```
    {
        "dni": "44444444",
        "tarjeta":"CLASICA",
        "moneda":"S/",
        "monto": 500,
        "cuota": 1,
        "tea":"90.00%",
        "diaPago":"5",
        "fechaCompra": "2021/02/10"
    }
```
- RESPONSE-BODY   :
```
    {
        "cuota": 728.005,
        "moneda": "S/",
        "primeraCuota": "05/03/2021",
        "estado": "Exitoso"
    }
```