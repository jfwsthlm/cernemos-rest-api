# Cernemos REST API

A Spring Boot RESTful web service providing cipher and text-transformation endpoints.

## Overview

`cernemos-rest-api` provides HTTP endpoints for encrypting and transforming text using classical cipher algorithms:
* **ROT13**: Rotates ASCII letters by 13 positions.
* **Substitution Cipher**: Replaces characters based on a custom key/character mapping.

---

## Tech Stack & Architecture

* **Language:** Java
* **Framework:** Spring Boot (`@RestController`, `@PostMapping`, `@RequestBody`)
* **Package Structure:** `se.sthlm.jfw.cernemos.api`
* **Dependencies:** `se.sthlm.jfwsthlm.cernemos.cipher`

---

## API Endpoints

### 1. ROT13 Cipher

Applies ROT13 substitution to the provided text.

* **URL:** `/rot13`
* **Method:** `POST`
* **Content-Type:** `application/json`

### 2. Custom Substitution Cipher

Substitutes characters in a string according to a provided key mapping.

* **URL:** `/substitution`
* **Method:** `POST`
* **Content-Type:** `application/json`