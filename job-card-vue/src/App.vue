<script setup>
// import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <img alt="DZT logo" class="logo" src="@/assets/logo.ico" width="150" height="75" />
    <div class="wrapper">
      <nav>
        <RouterLink to="/">DZT Job Manager Pro</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
  /* display: flex;
  justify-content: flex-start; */
}

nav {
  width: 100%;
  font-size: 50px;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

/* nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
} */

/* nav a:first-of-type {
  border: 0;
} */

@media (min-width: 1024px) {
  header {
    display: flex;
    justify-content: flex-end;
    /* padding-right: calc(var(--section-gap) / 2); */
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  /* header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  } */

  nav {
    display: flex;
    justify-content: flex-start;
    /* text-align: left; */
    margin-left: -1rem;
    font-size: 1rem;
    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
