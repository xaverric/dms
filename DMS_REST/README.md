# REST

## Návratový typ
Návratový typ všech metod je **ModelAndView**

Použití:
```
ModelAndView modelAndView = new ModelAndView("template_name"); 
modelAndView.addObject("variable_name", object);
return modelAndView;
```
* **template_name** - jméno html šablony thymeleafu
* **variable_name** - název proměnné použité v šabloně v EL výrazu
* **object** - hodnota uložená do proměnné
* **return** přesměruje na danou šablonu s nastavenými parametry (variable_name);
