			; Fait en cours, c'est le code du prof
	LDX 0, i	; X pour boucle
debut:	CPX 20, i
	BRGE fin

	LDA val_1, d	; L'addition
	ADDA val_2, d

	STA tmp, d	; print
	DECO tmp, d

	CHARO "\n", i	; println

	LDA val_2, d	; switch numbers
	STA val_1, d

	LDA tmp, d	; still switch
	STA val_2, d

	ADDX 1, i	; pour la boucle
	BR debut

fin: STOP

val_1: .WORD 0
val_2: .WORD 1
tmp: .WORD 0

.END
