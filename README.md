# powerpoint-DSL

## Motivation
###Target User
People who don't want to waste their time adjusting details in PowerPoint/ debugging Latex code.\\
###Effect
Make some neat presentation slides without dealing with annoying details (parameters, debudding)
## Features
1. Plain text input 
2. Plain/ Bold/ Italic
3. Font Color
4. Font size
5. Table of contents based on sections (navigation on click)
6. Mathematical formula (elementary operations)

## Install

## Usage
### Grammar
PROGRAM::= TITLE AUTHOR? (SECTION)*  
TITLE::="Title= " CONTENT “;”  
AUTHOR::= "Author: " CONTENT  
SECTION: "Section: " TITLE (PAGE)*  
PAGE::= "NewPage: " TITLE PAGESTUFF*  
PAGESTUFF::== POINT | PARAGRAPH | IMAGE
POINT::= "BulletPoint: " (CONTENT)*  
PARAGRAPH::= “Paragraph”: CONTENT  
IMAGE ::= “Image:” (IMAGEREF)*
IMAGEREF::= URL|PATH 
URL::= "Image Url:" STRING  
PATH::= "Image PATH: " STRING  
CONTENT::= "Content:" (SIZE | BI | COLOR)* (SENTENCE)*  
SENTENCE::= STRING | FORMULA  
SIZE::= "Size: " ("LARGE" or "Large" or "large")  
BI:: = "bi:" ("Bold" or "Italic") ("Bold" or "Italic")  
COLOR:: = "Color: " ("red" or "green" or ...)  
FORMULA::= "Formula: " STRING  
### Note
1. When we say "STRING" here, we mean any string without whitespaces and that is not a keyword.
2. Available colors: red, green, blue ... (there might be more ...)
3. Available font sizes: LARGE, Large, large
4. Available font styles: bold, italic
5. Animations are not supported

## Contributors
Feiyi Wang, Marta Yao, Pengwei Zhou, Jialu Zhang, Jialin Liu
## Acknowledgements
Open-source LaTex template (https://www.overleaf.com/latex/templates/a-modern-beamer-theme-mtheme/qzyvdhrntfmr#.Vjsvnt-qpBd) created by Matthias Vogelgesang


