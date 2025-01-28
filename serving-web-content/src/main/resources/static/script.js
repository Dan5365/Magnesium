let productsBottom = document.querySelector('#products');

productsBottom.addEventListener('click', (e) => {
    window.scrollBy({
        top: 500,
        behavior: 'smooth'
    });
})