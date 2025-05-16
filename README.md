# TrafficCounter

![App Demo](demo.gif)

Die **TrafficCounter**-App ist eine einfache Android-Anwendung zur Verkehrszählung von Fußgänger:innen und Radfahrer:innen. Die App wurde im Rahmen des Moduls Programmierung verteilter und mobiler Anwendungen entwickelt.

## Features

### Hauptfunktionen
- **Verkehrszählung:**
    - Separate Zähler für Fußgänger:innen und Radfahrer:innen
    - Gesamtzahlberechnung
    - Reset-Funktion für alle Zähler

- **Datenverwaltung:**
    - Speicherung aller Zählvorgänge mit Zeitstempel
    - Anzeige der Historie in einer Liste

### Navigation
- **BottomNavigationBar:**
    - Zähler (CounterScreen)
    - Auswertung (ListScreen)

- **TopAppBar mit Optionsmenü:**
    - Navigation zu allen Screens
    - Link zur TH Köln Website

### UI-Komponenten
- Custom TopAppBar mit Menü
- Custom BottomNavigationBar
- Material3 Design-System
- Responsive Layouts

## Screens

### 1. CounterScreen (Zähler)
- Zählt Fußgänger:innen und Radfahrer:innen
- Zeigt aktuelle Zählerstände an
- Reset-Button zum Zurücksetzen

### 2. ListScreen (Auswertung)
- Zeigt alle erfassten Daten an

### 3. InfoScreen
- Zeigt Teaminformationen an

## Technische Implementierung

### Architektur
- **Jetpack Compose** für UI
- **Navigation Component** für Screen-Navigation
- **ViewModel** für Zustandsverwaltung

### Wichtige Komponenten
- **TrafficViewModel:** Verwaltet alle Zähldaten
- **TrafficBottomNavigationBar:** Custom Navigation-Komponente
- **TrafficTopAppBar:** Custom AppBar mit Menü

## Entwickler:in
Dieses Projekt wurde von Bengin Sternas entwickelt.

## Installation

1. Projekt klonen:
   ```bash
   git clone https://gitlab.nt.fh-koeln.de/gitlab/vma/praktikum/vma29/traffic-counter-29.git