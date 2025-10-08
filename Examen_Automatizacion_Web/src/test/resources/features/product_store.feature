#language: es
Característica: Product - Store
  @examen
  Esquema del escenario: : Validación del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "<usuario>" y clave "<clave>"
    Cuando navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    Y agrego <cantidad> unidades del primer producto al carrito

    Ejemplos:
    | usuario                   | clave           | categoria | subcategoria  | cantidad  |
    | hadmysantos.o@outlook.com | paasswoord9874  | Clothes   | Men           | 2         |
