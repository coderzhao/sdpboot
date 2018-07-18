$(document).ready(function(){
  document.getElementById('fileinput').onchange = function(e) {
      var imageFile = this.files[0];
      var url = window.URL.createObjectURL(imageFile);
      $(".modal-body .row .col-lg-4 .img-responsive").attr("src", url);
  };
});
