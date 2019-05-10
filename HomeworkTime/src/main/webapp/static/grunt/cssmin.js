module.exports = {

    minify: {
        expand: true,
        cwd: 'dist/stylesheets/',
        src: ['*.css', '!*.min.css'],
        dest: 'dist/stylesheets/minify/',
        ext: '.min.css'
      }

};
