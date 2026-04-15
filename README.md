# VPS Task Manager

![Java](https://img.shields.io/badge/Java-11-orange) ![Spring MVC](https://img.shields.io/badge/Spring-MVC-green) ![MySQL](https://img.shields.io/badge/MySQL-8.0-blue) ![License](https://img.shields.io/badge/license-MIT-lightgrey)

Sistema web de gestión de tareas internas desarrollado para VPS Solutions. Resuelve el problema de mensajes perdidos y falta de seguimiento en equipos pequeños.

## Tabla de Contenidos
- [Descripción](#descripción)
- [Problema identificado](#problema-identificado)
- [Solución](#solución)
- [Arquitectura](#arquitectura)
- [Requerimientos](#requerimientos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Uso](#uso)
- [Contribución](#contribución)
- [Roadmap](#roadmap)

## Descripción
Aplicación web MVC que permite crear, asignar y dar seguimiento a tareas internas entre los miembros del equipo de VPS Solutions.

## Problema identificado
VPS Solutions gestiona su comunicación interna por WhatsApp y correo. Los encargos se pierden en el flujo de conversación, generando tareas sin ejecutar y sin seguimiento.

## Solución
Aplicación web con tablero Kanban que centraliza las tareas, permite asignar responsables, establecer fechas límite y registrar el historial de cambios.

## Arquitectura
- **Capa de presentación:** Navegador web — Vistas JSP
- **Capa de aplicación:** Apache Tomcat 9 + Spring MVC 5 + JDBC
- **Capa de datos:** MySQL 8 — tablas: usuarios, tareas, historial
- **CI/CD:** GitHub Actions + JUnit
- **Gestión de proyecto:** Zube.io

## Requerimientos

### Servidores
| Componente | Versión |
|---|---|
| Apache Tomcat | 9.0.x |
| MySQL | 8.0.x |
| JDK | 11 o superior |

### Paquetes adicionales
- Spring MVC 5.3.27
- MySQL Connector/J 8.0.33
- JSTL 1.2
- JUnit 4.13.2
- Maven 3.x

## Instalación

### Ambiente de desarrollo
1. Instalar JDK 17, NetBeans 25, Apache Tomcat 9, XAMPP
2. Clonar el repositorio:
```bash
git clone https://github.com/AmE2004/vps-task-manager.git
```
3. Abrir en NetBeans → File → Open Project
4. Ejecutar el script SQL:
```bash
mysql -u root -p < src/main/resources/schema.sql
```
5. Clean and Build → Run

### Ejecutar pruebas
```bash
mvn test
```

### Implementacion local (WAR)
1. Clean and Build genera el WAR en `target/vps-task-manager-1.0-SNAPSHOT.war`
2. Copiar el WAR a `TOMCAT_HOME/webapps/`
3. Iniciar Tomcat
4. Acceder a `http://localhost:8080/vps-task-manager/login`

## Configuración

### Base de datos
Editar `src/main/java/com/vps/vps/task/manager/ConexionDB.java`:
```java
private static final String URL = "jdbc:mysql://localhost:3306/vps_tasks";
private static final String USER = "root";
private static final String PASSWORD = "";
```

### Tomcat
Configurar el servidor en NetBeans: Tools → Servers → Apache Tomcat 9

## Uso

### Usuario administrador (Director)
- **Email:** director@vps.com
- **Contraseña:** admin123
- Puede crear y asignar tareas a cualquier usuario
- Puede ver todas las tareas en el tablero
- Puede generar reportes

### Usuario final (Empleado)
- **Email:** empleado1@vps.com
- **Contraseña:** emp123
- Puede ver sus tareas asignadas
- Puede cambiar el estado de sus tareas
- Puede ver el historial de cambios

## Contribución

### Pasos para contribuir
1. Clonar el repositorio:
```bash
git clone https://github.com/AmE2004/vps-task-manager.git
```
2. Crear un branch para tu feature:
```bash
git checkout develop
git checkout -b feature/nombre-de-la-feature
```
3. Hacer commits con mensajes descriptivos:
```bash
git commit -m "feat: descripción del cambio"
```
4. Push al branch:
```bash
git push origin feature/nombre-de-la-feature
```
5. Abrir un Pull Request hacia `develop` en GitHub
6. Esperar revisión y aprobación para el merge

## Roadmap

### Versión 2.0 (GA futura)
- Recuperación de contraseña por email
- Notificaciones por correo electrónico
- Exportar reportes a PDF/Excel
- Drag & drop en el tablero Kanban
- Roles granulares y permisos por módulo
- Autenticación con Google
- App móvil
