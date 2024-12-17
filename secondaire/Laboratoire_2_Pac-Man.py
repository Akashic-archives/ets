from turtle import *
# on import time pour la fin pour que le dessin reste a l'ecran 1 000 000 secondes
import time
# on regle la vitesse de la tortue
speed(0.1)
# "rayon" du carré
a = 252
penup()
goto(-a, a)
pendown()

x = 0
b = 0
d = 0
# le backgroud
pencolor("black")
begin_fill()
forward(2*a)
right(135)
forward(2*((a*a+a*a)**0.5))
right(135)
forward(2*a)
right(90)
end_fill()
goto(a, -a)
left(180)
begin_fill()
forward(2*a)
right(135)
forward(2*((a*a+a*a)**0.5))
right(135)
forward(2*a)
right(90)
end_fill()
setheading(0)


# on defini le cube bleu
def cube_bleu():
    y = 0
    while y < 12:
        pencolor("blue")
        forward(24)
        right(90)
        forward(1)
        right(90)
        forward(24)
        left(90)
        forward(1)
        left(90)
        y = y + 1


# on defini le cube gris
def cube_gris():
    y = 0
    while y < 12:
        pencolor("grey")
        forward(24)
        right(90)
        forward(1)
        right(90)
        forward(24)
        left(90)
        forward(1)
        left(90)
        y = y + 1


# on defini le grand "bonbon" de pac man
def cercle():
    pencolor("white")
    penup()
    goto(b, d)
    pendown()
    dot(24)


# on defini le petit "bonbon" de pac man
def petitcercle():
    pencolor("white")
    penup()
    goto(b, d)
    pendown()
    dot(6)


# on defini le corps du fantome
def body_fantome():
    e = 0
    while e != 19:
        e = e+1
        forward(9.95)
        right(90)
        forward(0.25)
        right(90)
        forward(9.95)
        left(90)
        forward(0.25)
        left(90)


# on fait la premiere ligne des carres bleus
# 1
for i in [-252, -228, -204, -156, -132, -108, -84, -60, -36, -12, 12, 36, 60, 84, 108, 132, 180, 204, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 252)
    pendown()
    cube_bleu()
# on fait la 2 eme ligne des carres bleus
# 2
for i in [-252, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 228)
    pendown()
    cube_bleu()
# on fait la 3 eme ligne des carres bleus
# 3
for i in [-252, -204, -156, -132, -108, -84, -60, -36, -12, 12, 36, 60, 84, 108, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 204)
    pendown()
    cube_bleu()
# on fait la 4 eme ligne des carres bleus
# 4
for i in [-252, -204, -156, -132, -108, -60, -36, -12, 12, 36, 84, 108, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 156)
    pendown()
    cube_bleu()
# on fait la 5 eme ligne des carres bleus
# 5
for i in [-252, -204, -156, -12, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 132)
    pendown()
    cube_bleu()
# on fait la 6 eme ligne des carres bleus
# 6
for i in [-252, -204, -156, -108, -84, -60, -12, 36, 60, 84, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 108)
    pendown()
    cube_bleu()
# on fait la 7 eme ligne des carres bleus
# 7
for i in [-252, -204, -108, 84, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 84)
    pendown()
    cube_bleu()
# on fait la 8 eme ligne des carres bleus
# 8
for i in [-252, -204, -156, -108, -60, -36, 12, 36, 84, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 60)
    pendown()
    cube_bleu()
# on fait la 9 eme ligne des carres bleus
# 9
for i in [-252, -204, -156, -60, 36, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 36)
    pendown()
    cube_bleu()
# on fait la 10 eme ligne des carres bleus
# 10
for i in [-252, -204, -156, -132, -108, 84, 108, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, 12)
    pendown()
    cube_bleu()
# on fait la 11 eme ligne des carres bleus
# -9
for i in [-252, -204, -156, -60, 36, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, -12)
    pendown()
    cube_bleu()
# on fait la 12 eme ligne des carres bleus
# -8
for i in [-252, -204, -156, -108, -60, -36, 12, 36, 84, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, -36)
    pendown()
    cube_bleu()
# on fait la 13 eme ligne des carres bleus
# -7
for i in [-252, -204, -108, 84, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, -60)
    pendown()
    cube_bleu()
# on fait la 14 eme ligne des carres bleus
# -6
for i in [-252, -204, -156, -108, -84, -60, -12, 36, 60, 84, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, -84)
    pendown()
    cube_bleu()
# on fait la 15 eme ligne des carres bleus
# -5
for i in [-252, -204, -156, -12, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, -108)
    pendown()
    cube_bleu()
# on fait la 16 eme ligne des carres bleus
# -4
for i in [-252, -204, -156, -132, -108, -60, -36, -12, 12, 36, 84, 108, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, -132)
    pendown()
    cube_bleu()
# on fait la 17 eme ligne des carres bleus
# -3
for i in [-252, -204, -156, -132, -108, -84, -60, -36, -12, 12, 36, 60, 84, 108, 132, 180, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, -180)
    pendown()
    cube_bleu()
# on fait la 18 eme ligne des carres bleus
# -2
for i in [-252, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, -204)
    pendown()
    cube_bleu()
# on fait la 19 eme ligne des carres bleus
# -1
for i in [-252, -228, -204, -156, -132, -108, -84, -60, -36, -12, 12, 36, 60, 84, 108, 132, 180, 204, 228, 500]:
    if i == 500:
        break
    penup()
    goto(i, -228)
    pendown()
    cube_bleu()


# on fais les cubes gris
penup()
goto(-204, 228)
pendown()
cube_gris()
penup()
goto(-228, 204)
pendown()
cube_gris()

penup()
goto(180, 228)
pendown()
cube_gris()
penup()
goto(204, 204)
pendown()
cube_gris()

penup()
goto(-204, -204)
pendown()
cube_gris()
penup()
goto(-228, -180)
pendown()
cube_gris()

penup()
goto(204, -180)
pendown()
cube_gris()
penup()
goto(180, -204)
pendown()
cube_gris()

# b=x d=y
# on fait la 1 ere ligne des petits cercles
# 1
for i in [-144, -120, -96, -72, -48, -24, 0, 24, 48, 72, 96, 120, 144, 500]:
    if i == 500:
        break
    b = i
    d = 216
    petitcercle()
# on fait la 2 eme ligne des petits cercles
# 2
for i in [-168, -144, -120, -96, -72, -48, -24, 0, 24, 48, 72, 96, 120, 144, 168, 500]:
    if i == 500:
        break
    b = i
    d = 168
    petitcercle()
# on fait la 3 eme ligne des petits cercles
# 3
for i in [-216, -168, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = 144
    petitcercle()
# on fait la 4 eme ligne des petits cercles
# 4
for i in [-216, -168, -120, -96, -72, -48, -24, 24, 48, 72, 96, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = 120
    petitcercle()
# on fait la 5 eme ligne des petits cercles
# 5
for i in [-216, -168, -120, -24, 24, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = 96
    petitcercle()
# on fait la 6 eme ligne des petits cercles
# 6
for i in [-216, -168, -120, -72, -48, -24, 0, 24, 48, 72, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = 72
    petitcercle()
# on fait la 7 eme ligne des petits cercles
# 7
for i in [-216, -168, -120, -72, 72, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = 48
    petitcercle()
# on fait la 8 eme ligne des petits cercles
# 8
for i in [-216, -168, -120, -96, -72, 72, 96, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = 24
    petitcercle()
# on fait la 9 eme ligne des petits cercles
# 9
for i in [-216, -168, -72, 72, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = 0
    petitcercle()
# on fait la 10 eme ligne des petits cercles
# -8
for i in [-216, -168, -120, -96, -72, 72, 96, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = -24
    petitcercle()
# on fait la 11 eme ligne des petits cercles
# -7
for i in [-216, -168, -120, -72, 72, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = -48
    petitcercle()
# on fait la 12 eme ligne des petits cercles
# -6
for i in [-216, -168, -120, -72, -48, -24, 0, 24, 48, 72, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = -72
    petitcercle()
# on fait la 13 eme ligne des petits cercles
# -5
for i in [-216, -168, -120, -24, 24, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = -96
    petitcercle()
# on fait la 14 eme ligne des petits cercles
# -4
for i in [-216, -168, -120, -96, -72, -48, -24, 24, 48, 72, 96, 120, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = -120
    petitcercle()
# on fait la 15 eme ligne des petits cercles
# -3
for i in [-216, -168, 168, 216, 500]:
    if i == 500:
        break
    b = i
    d = -144
    petitcercle()
# on fait la 16 eme ligne des petits cercles
# -2
for i in [-168, -144, -120, -96, -72, -48, -24, 0, 24, 48, 72, 96, 120, 144, 168, 500]:
    if i == 500:
        break
    b = i
    d = -168
    petitcercle()
# on fait la 17 eme ligne des petits cercles
# -1
for i in [-144, -120, -96, -72, -48, -24, 0, 24, 48, 72, 96, 120, 144, 500]:
    if i == 500:
        break
    b = i
    d = -216
    petitcercle()

# pacman
pencolor("yellow")
penup()
goto(0, 0)
pendown()
dot(24)
seth(0)
left(45)
pencolor("black")
begin_fill()
forward(24)
seth(180)
forward(34)
left(135)
forward(24)
end_fill()
seth(0)

# fantome rouge
pencolor("red")
penup()
goto(-221, 219.5)
pendown()
body_fantome()
goto(-216, 219.5)
dot(10, "red")

penup()
goto(-218.5, 210)
pendown()
pencolor("black")
dot(4)
penup()
goto(-213.5, 210)
pendown()
dot(4)

# oeil fantom
penup()
goto(-218.5, 219.5)
pendown()
dot(4, "white")
dot(2, "black")
penup()
goto(-213.5, 219.5)
pendown()
dot(4, "white")
dot(2, "black")

# fantome rose
pencolor("pink")
penup()
goto(-221, -211.5)
pendown()
body_fantome()
goto(-216, -211.5)
dot(10, "pink")

penup()
goto(-218.5, -221)
pendown()
pencolor("black")
dot(4)
penup()
goto(-213.5, -221)
pendown()
dot(4)

# oeil fantom
penup()
goto(-218.5, -211.5)
pendown()
dot(4, "white")
dot(2, "black")
penup()
goto(-213.5, -211.5)
pendown()
dot(4, "white")
dot(2, "black")


# fantome bleu
pencolor("blue")
penup()
goto(211.05, -211.5)
pendown()
body_fantome()
goto(216, -211.5)
dot(10, "blue")

penup()
goto(218.5, -221)
pendown()
pencolor("black")
dot(4)
penup()
goto(213.5, -221)
pendown()
dot(4)

# oeil fantom
penup()
goto(218.5, -211.5)
pendown()
dot(4, "white")
dot(2, "black")
penup()
goto(213.5, -211.5)
pendown()
dot(4, "white")
dot(2, "black")

# fantome orange
pencolor("orange")
penup()
goto(211.05, 219.5)
pendown()
body_fantome()
goto(216, 219.5)
dot(10, "orange")

penup()
goto(218.5, 210)
pendown()
pencolor("black")
dot(4)
penup()
goto(213.5, 210)
pendown()
dot(4)

# oeil fantom
penup()
goto(218.5, 219.5)
pendown()
dot(4, "white")
dot(2, "black")
penup()
goto(213.5, 219.5)
pendown()
dot(4, "white")
dot(2, "black")

# on fait les grands cercles
b = 0
d = 216
cercle()
d = -216
cercle()
b = 216
d = 0
cercle()
b = -216
cercle()

# retour en haut a gauche
penup()
goto(-a, a)
# time sleep pour qu'il reste 16 minutes environ
time.sleep(1000000)
done