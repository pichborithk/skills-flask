/** @type {import('tailwindcss').Config} */
export default {
  content: ['./index.html', './src/**/*.{js,ts,jsx,tsx}'],
  theme: {
    extend: {
      fontFamily: {
        gilroy: ['Gilroy-ExtraBold', 'serif'],
        gilroyLight: ['Gilroy-Light', 'serif'],
        jura: ['Jura', 'san-serif'],
      },
      colors: {
        // primary: { DEFAULT: '#eb455f' },
        // secondary: { DEFAULT: '#fcffe7' },
        checked: { DEFAULT: '#1bca00' },
        primary: { DEFAULT: '#F652A0' },
        secondary: { DEFAULT: '#36eee0' },
        status: { success: '#00B087', error: '#FFC5C5' },
      },
      boxShadow: {
        full: '0px 1px 6px 1px rgba(0, 0, 0, 0.4)',
      },
    },
  },
  plugins: [],
};
