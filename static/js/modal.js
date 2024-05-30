document.addEventListener('DOMContentLoaded', (event) => {
    const modal = document.getElementById("modal");
    const modalImg = document.getElementById("modal-img");
    const captionText = document.getElementById("caption");
    const closeModal = document.getElementsByClassName("close")[0];

    const images = document.querySelectorAll('.image-list-item img');
    images.forEach(image => {
        image.onclick = function(){
            modal.style.display = "block";
            modalImg.src = this.src;
            captionText.innerHTML = this.alt;
        }
    });

    closeModal.onclick = function() { 
        modal.style.display = "none";
    }

    modal.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
});
/**
 * 
 */