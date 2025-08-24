# 🔐 Sistema de Gestión de Automóviles con Roles en Java

Este proyecto es una aplicación Java con interfaz gráfica (Swing) que permite gestionar automóviles mediante un sistema de roles. Está estructurado en tres capas: **Interfaz Gráfica (IGU)**, **Lógica de Negocio**, y **Persistencia**, y utiliza **JPAController** para la gestión de datos.

---

## 👥 Roles de Usuario

- **Administrador**
  - Puede **consultar**, **dar de alta**, **modificar** y **eliminar** automóviles.
  - Accede a interfaces gráficas adicionales para alta y edición.
  
- **Usuario**
  - Solo puede **consultar** los datos.
  - No tiene acceso a funciones de modificación, alta ni eliminación.

---

## 🧱 Estructura del Proyecto

- **IGU (Interfaz Gráfica):** Ventanas para login, consulta, alta y edición.
- **Lógica:** Clase `Automovil` y control de roles.
- **Persistencia:** Controladores JPA para acceso a la base de datos.

src/ 
├── igu/ ← Ventanas y formularios Swing 
├── logica/ ← Clase Automovil y lógica de roles 
└── persistencia/ ← JPAController y entidades


---

## 🛠️ Funcionalidades

- 🔐 Login con rol de usuario o administrador
- 🔍 Consulta de automóviles
- ➕ Alta de nuevos automóviles (solo administrador)
- ✏️ Edición de datos (solo administrador)
- ❌ Eliminación de registros (solo administrador)

---

## 🧰 Tecnologías Utilizadas

- Java SE
- NetBeans IDE
- Swing (GUI)
- JPA (Java Persistence API)
- Base de datos relacional (MySQL, Derby, etc.)

---

## 🚀 Cómo Ejecutar

1. Clona o descarga el proyecto.
2. Abre el proyecto en NetBeans.
3. Configura la conexión a la base de datos en la capa de persistencia.
4. Ejecuta la clase principal desde la carpeta `igu`.
5. Inicia sesión como **administrador** o **usuario** para acceder a las funcionalidades correspondientes.

---

## 📄 Licencia

Este proyecto es de uso libre para fines educativos y personales.
