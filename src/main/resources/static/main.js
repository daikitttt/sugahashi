//function chColorF(id) { 
//    const listItem = document.getElementById(id);
//    if (listItem) {
//        const color = 'rgb(255, 0, 0)';
//        listItem.style.color = color;
//    } else {
//        console.error('Element not found:', id);
//    }
//}
//function chColorM(){
//	const button = document.getElementsClassName('changeC');
//	const color = 'rgb(255,165,0)';
//	button.style.color = color;
//}


function chColorF(index) {
    var liElement = document.getElementById('changeC' + index);
    var currentColor = liElement.style.color;
    liElement.style.color = currentColor === 'red' ? 'black' : 'red';
}