<template>
  <div>
    <div class="signature-pad">
      <div class="signature-pad--body">
        <canvas
          id="canvas"
          width="900"
          height="600"
          style="touch-action: none"
        ></canvas>
      </div>
    </div>
    <br />
    <br />
    <section class="container-fluid">
      <div class="row">
        <div class="col-6">
          <button class="btn btn-block btn-danger" @click="clear()">
            Clear
          </button>
          <button class="btn btn-block btn-warning" @click="undo()">
            Undo
          </button>
          <button class="btn btn-block btn-info" @click="changeColor()">
            Change Color
          </button>
        </div>
        <div class="col-6">
          <button class="btn btn-block btn-success" @click="savePNG()">
            PNG
          </button>
          <button class="btn btn-block btn-primary" @click="saveJPG()">
            JPG
          </button>
          <button class="btn btn-block btn-secondary" @click="saveSVG()">
            SVG
          </button>
        </div>
      </div>
    </section>
  </div>
</template>

<script lang="ts">
import { Vue } from "vue-class-component";
import SignaturePad from "signature_pad";

export default class HelloWorld extends Vue {
  signaturePad = new SignaturePad(<HTMLCanvasElement> (document.getElementById("canvas")));

  changeColor(): void {
    const r = Math.round(Math.random() * 255);
    const g = Math.round(Math.random() * 255);
    const b = Math.round(Math.random() * 255);
    this.signaturePad.penColor = "rgb(" + r + "," + g + "," + b + ")";
  }

  clear(): void {
    this.signaturePad.clear();
  }

  undo(): void {
    const data = this.signaturePad.toData();
    if (data) {
      data.pop(); // remove the last dot or line
      this.signaturePad.fromData(data);
    }
  }

  download(dataURL: string, filename: string): void {
    if (
      navigator.userAgent.indexOf("Safari") > -1 &&
      navigator.userAgent.indexOf("Chrome") === -1
    ) {
      window.open(dataURL);
    } else {
      const blob = this.dataURLToBlob(dataURL);
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement("a");
      a.href = url;
      a.download = filename;

      document.body.appendChild(a);
      a.click();

      window.URL.revokeObjectURL(url);
    }
  }

  dataURLToBlob(dataURL: string): Blob {
    // Code taken from https://github.com/ebidel/filer.js
    const parts = dataURL.split(";base64,");
    const contentType = parts[0].split(":")[1];
    const raw = window.atob(parts[1]);
    const rawLength = raw.length;
    const uInt8Array = new Uint8Array(rawLength);
    for (let i = 0; i < rawLength; ++i) {
      uInt8Array[i] = raw.charCodeAt(i);
    }
    return new Blob([uInt8Array], { type: contentType });
  }

  savePNG(): void {
    if (this.signaturePad.isEmpty()) {
      alert("Please provide a signature first.");
    } else {
      const dataURL = this.signaturePad.toDataURL();
      this.download(dataURL, "signature.png");
    }
  }

  saveJPG(): void {
    if (this.signaturePad.isEmpty()) {
      alert("Please provide a signature first.");
    } else {
      const dataURL = this.signaturePad.toDataURL("image/jpeg");
      this.download(dataURL, "signature.jpg");
    }
  }

  saveSVG(): void {
    if (this.signaturePad.isEmpty()) {
      alert("Please provide a signature first.");
    } else {
      const dataURL = this.signaturePad.toDataURL("image/svg+xml");
      this.download(dataURL, "signature.svg");
    }
  }
}
</script>

<style scoped></style>
