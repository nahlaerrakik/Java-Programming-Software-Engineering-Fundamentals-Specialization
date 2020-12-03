var original_image = null

function clearCanvas(canvas) {
    var ctx = canvas.getContext('2d');
    ctx.clearRect(0, 0, canvas.width, canvas.height);
}


function loadImage(){
    var canvas = document.getElementById("canvas");
    var file = document.getElementById("file_input");
    var img = new SimpleImage(file);
    original_image = img;

    clearCanvas(canvas);
    img.drawTo(canvas);
}

function grayScale(){
    var canvas = document.getElementById("canvas");
    var img = original_image;
    
    for (var pix of img.values()){
        var avgcol = (pix.getRed() + pix.getBlue() + pix.getGreen()) / 3;
        pix.setRed(avgcol);
        pix.setBlue(avgcol);
        pix.setGreen(avgcol);
    }

    clearCanvas(canvas);
    img.drawTo(canvas);
}

function colorRed(){
    var canvas = document.getElementById("canvas");
    var img = original_image;
    
    for (var pix of img.values()){
        var avgcol = (pix.getRed() + pix.getBlue() + pix.getGreen()) / 3;
        pix.setRed(avgcol);
        pix.setBlue(0);
        pix.setGreen(0);
    }

    clearCanvas(canvas);
    img.drawTo(canvas);
}

function resetImage(){
    var canvas = document.getElementById("canvas");
    var img = original_image;

    clearCanvas(canvas);
    img.drawTo(canvas);
}

function redFilter(){
    var canvas = document.getElementById("canvas");
    var img = original_image;

    for (var pix of img.values()){
        var avgcol = (pix.getRed() + pix.getBlue() + pix.getGreen()) / 3;
        if(avgcol < 128){
            pix.setRed(2*avgcol);
            pix.setBlue(0);
            pix.setGreen(0);
        }
        else{
            pix.setRed(255);
            pix.setBlue(2*avgcol - 255);
            pix.setGreen(2*avgcol - 255); 
        }        
    }

    clearCanvas(canvas);
    img.drawTo(canvas);
}
