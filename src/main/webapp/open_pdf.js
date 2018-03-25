function renderPDF( pdfBase64 ) {

    var pdfUint8Array = base64ToUint8Array( pdfBase64 );

    var canvasContainer = document.getElementById('myCanvasContainer');
    var options = options || { scale: 1.5 };

    function renderPage(page) {
        var viewport = page.getViewport(options.scale);
        var canvas = document.createElement('canvas');
        var ctx = canvas.getContext('2d');
        var renderContext = {
            canvasContext: ctx,
            viewport: viewport
        };

        canvas.height = viewport.height;
        canvas.width = viewport.width;
        canvasContainer.appendChild(canvas);

        page.render(renderContext);
    }
    function renderPages(pdfDoc) {
        for(var num = 1; num <= pdfDoc.numPages; num++)
            pdfDoc.getPage(num).then(renderPage);
    }

    function base64ToUint8Array(base64) {
        var raw = atob(base64);
        var uint8Array = new Uint8Array(raw.length);
        for (var i = 0; i < raw.length; i++) {
            uint8Array[i] = raw.charCodeAt(i);
        }
        return uint8Array;
    }


    PDFJS.disableWorker = true;
    PDFJS.getDocument(pdfUint8Array).then(renderPages);

}