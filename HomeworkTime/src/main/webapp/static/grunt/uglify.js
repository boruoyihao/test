module.exports = {
    compress: {
        expand: true,
          cwd: 'scripts',
          src: ['modules/**/*.js', 'apps/**/*.js', '*.js'],
          dest: 'dist/scripts/',
          ext: '.min.js'
    }
};
