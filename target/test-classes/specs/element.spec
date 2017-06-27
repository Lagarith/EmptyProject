@objects

	body	xpath	/html/body
	header  xpath	/html/body/div/div/div[2]/div[2]/div[1]
	header-logo	xpath	/html/body/div/div/div[2]/div[2]/div[1]/div/div/a

	loginform	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[1]/form
	loginform-title	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[1]/form/div[1]/span
	loginform-email-caption	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[1]/form/div[2]/div/div[1]/div[1]
	loginform-email-input	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[1]/form/div[2]/div/div[2]/input
	loginform-password-caption	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[1]/form/div[3]/div/div[1]/div[1]
	loginform-password-input	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[1]/form/div[3]/div/div[2]/input
	loginform-button	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[1]/form/button

	main-container	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[1]
	footer	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div

	footer-detals	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div/div[1]
	footer-copyright	xpath	/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div

= Header =
	header:
		width 100% of screen/width
		height 68px
		inside body 0px top

	header-logo:
		height 100% of header/height
		width 200px
		centered horizontally inside header



=  Authorization form =
	loginform:
		centered horizontally inside main-container
		centered vertically inside main-container
		width 258px
		height 302px
		below header 40 to 50 px

	loginform-title:
		inside loginform 31px top left
		text is "Войти"

	loginform-email-caption:
		inside loginform 31px left
		below loginform-title 20 to 25 px
		text is "Эл. почта"

	loginform-email-input:
		inside loginform 31px left right
		centered horizontally inside loginform
		below loginform-email-caption 3 to 7 px

	loginform-password-caption:
		inside loginform 31px left
		below loginform-email-input 20 to 25 px
		text is "Пароль"

	loginform-password-input:
		inside loginform 31px left right
		centered horizontally inside loginform
		below loginform-password-caption 3 to 7 px

	loginform-button:
		inside loginform 31px left right bottom
		centered horizontally inside loginform
		text is "Войти"



= footer =
	footer-detals:
		aligned vertically left footer

	footer-copyright:
		aligned vertically right footer









