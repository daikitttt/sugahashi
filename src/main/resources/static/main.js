function chColorF(){
	const color = 'rgb(255,0,0)';
	button.style.color = color;
}
function chColorM(){
	const color = 'rgb(255,165,0)';
	button.style.color = color;
}
function clickCC(){
	const button = document.getElementById('changeColor');
	button.addEventListener('click', () => {
		chColorF();
	})
}