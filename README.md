# powerpoint-DSL

## Motivation

###Target User  
People who don't want to waste their time adjusting details in PowerPoint/ debugging Latex code.   
###Effect   
Make some neat presentation slides without dealing with annoying details (parameters, debudding)
## Features
1. Plain text input 
2. Plain/ Bold/ Italic
3. Font Color
4. Font size
5. Table of contents based on sections (navigation on click)
6. Mathematical formulas (elementary operations)  // stretch goal

## Mac Install
1. Install [Homebrew](https://docs.brew.sh/Installation).
2. Install [LaTex](https://tug.org/mactex/morepackages.html).
   By typing the following command in your Terminal
   
   <code>brew cask install basictex</code>
   
   Note: `BasicTex`(80 MB) is highly recommended than `MacTex`(4 GB+) as it required less space.
   

## Windows Install
1. Install [LaTex](https://www.latex-project.org/get/). 
2. TBD

## Usage
### Grammar
PROGRAM::= TITLE (AUTHOR)? (SECTION)* \
TITLE::="Title: " CONTENT \
AUTHOR::= "Author: " CONTENT \
SECTION: "Section: " TITLE (PAGE)* \
PAGE::= "NewPage: " TITLE PAGESTUFF* \
PAGESTUFF::= POINT | PARAGRAPH | IMAGE \
POINT::= "BulletPoint: " CONTENT \
PARAGRAPH ::= “Paragraph”: CONTENT \
IMAGE ::= “Image:” IMAGEREF \
IMAGEREF::= URL|PATH \
URL::= "ImageUrl:" STRING \
PATH::= "ImagePATH: " STRING \
CONTENT::= (( “@(” (SIZE | BI | COLOR)+  “)” )?  SENTENCE)+       //EXAMPLE : @(bold, RED) Hello ADAD \
SENTENCE::= STRING \
 \
SIZE::= “Small” or “Normal” or "Big" or "Large" or "Huge” \
BI:: = "Bold" or "Italic” \
COLOR:: = "red" or "green" ... \

FORMULA::= "Formula: " STRING  //STRETCH GOAL

### Note
1. When we say "STRING" here, we mean any string without whitespaces and that is not a keyword.
2. Available colors: red, green, blue ... (there might be more ...)
3. Available font sizes: small, normal, big, large, huge
4. Available font styles: bold, italic
5. Animations are not supported

## Contributors
Feiyi Wang, Marta Yao, Pengwei Zhou, Jialu Zhang, Jialin Liu
## Acknowledgements
Open-source LaTex template (https://www.overleaf.com/latex/templates/a-modern-beamer-theme-mtheme/qzyvdhrntfmr#.Vjsvnt-qpBd) created by Matthias Vogelgesang


