<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App" />
    <SignaturePad></SignaturePad>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import HelloWorld from "@/components/HelloWorld.vue";
import SignaturePad from "@/components/SignaturePad.vue"; // @ is an alias to /src

@Options({
  components: {
    SignaturePad,
    HelloWorld,
  },
})
export default class Home extends Vue {}
</script>
