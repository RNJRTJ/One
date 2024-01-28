console.log("Hello slider!");

$(document).ready(function () {
            $(".js-slider").slick({
                dots: true,
                infinite: true,
                speed: 800,
                arrows: false,
                slidesToShow: 4,
                slidesToScroll: 1,
                autoplay: true,
  				autoplaySpeed: 2000,
                responsive: [
                    {
                        breakpoint: 1200,
                        settings: {
                            slidesToShow: 3,
                            slidesToScroll: 1,
                        },
                    },
                    {
                        breakpoint: 1060,
                        settings: {
                            slidesToShow: 2,
                            slidesToScroll: 1,
                        },
                    },
                    {
                        breakpoint: 1060,
                        settings: {
                            slidesToShow: 2,
                            slidesToScroll: 1,
                        },
                    },
                    {
                        breakpoint: 660,
                        settings: {
                            slidesToShow: 2,
                            slidesToScroll: 1,
                        },
                    },
                    
                    {
                        breakpoint: 625,
                        settings: {
                            slidesToShow: 1,
                            slidesToScroll: 1,
                        },
                    },
                    {
                        breakpoint: 560,
                        settings: {
                            slidesToShow: 1,
                            slidesToScroll: 1,
                        },
                    },
                ],
            });
        });

        function slickPrev() {
            $(".js-slider").slick('slickPrev');
            
        }

        function slickNext() {
            $(".js-slider").slick('slickNext');
            
        }
        
        
$(document).ready(function () {
            $(".js-slider1").slick({
                dots: true,
                infinite: true,
                speed: 700,
                arrows: false,
                slidesToShow: 4,
                slidesToScroll: 1,
                autoplay: true,
  				autoplaySpeed: 2000,
                responsive: [
					{
                        breakpoint: 1425,
                        settings: {
                            slidesToShow: 4,
                            slidesToScroll: 1,
                        },
                    },
                    {
                        breakpoint: 1200,
                        settings: {
                            slidesToShow: 3,
                            slidesToScroll: 1,
                        },
                    },
                    {
                        breakpoint: 1060,
                        settings: {
                            slidesToShow: 2,
                            slidesToScroll: 1,
                        },
                    },
                    {
                        breakpoint: 1060,
                        settings: {
                            slidesToShow: 2,
                            slidesToScroll: 1,
                        },
                    },
                    {
                        breakpoint: 660,
                        settings: {
                            slidesToShow: 2,
                            slidesToScroll: 1,
                        },
                    },
                    
                    {
                        breakpoint: 625,
                        settings: {
                            slidesToShow: 1,
                            slidesToScroll: 1,
                        },
                    },
                    {
                        breakpoint: 560,
                        settings: {
                            slidesToShow: 1,
                            slidesToScroll: 1,
                        },
                    },
                ],
            });
        });

        function slickPrev1() {
            $(".js-slider1").slick('slickPrev');
            
        }

        function slickNext1() {
            $(".js-slider1").slick('slickNext');
            
        }     