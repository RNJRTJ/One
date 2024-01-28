const empreendimentos = [];

const fetchEnterprises = (image) => {
    fetch(image.src)
        .then((response) => response.text())
        .then((response) => {
            const span = document.createElement('span');
            span.innerHTML = response;
            const inlineSVG = span.getElementsByTagName('svg')[0];
            image.parentNode.replaceChild(inlineSVG, image);
            return true;
        })
        .then(() => { getActions() });
}

const getActions = () => {
    const enterprises = document.getElementsByClassName('enterprise');
    for (let i = 0; i < enterprises.length; i++) {


        enterprises[i].addEventListener('mouseover', function () {
            fillPopover(enterprises[i]);
        });

        enterprises[i].addEventListener('mouseout', function () {
            hidePopover(enterprises[i]);
        })
    }
    getEnterprises();
};


const getEnterprises = async () => {

    try {
        const response = await fetch('js/enterprises.json');
        const empreendimentos = await response.json();
        return empreendimentos;


    } catch (error) {
        console.error('Erro ao obter estados:', error);
    }
};

const fillPopover = async (enterprise) => {

    const idEnterprise = enterprise.getAttribute('identerprise');
    const empreendimentos = await getEnterprises();
    const numLoja = empreendimentos.find(empreendimento => empreendimento.idEnterprise === idEnterprise);

    const popover = new bootstrap.Popover(enterprise, {
        placement: 'top',
        title: numLoja.fantasyName,
        content: `Descrição: ${numLoja.description}. \n Número da Loja: ${numLoja.numStore} `,
        template: '<div class="popover popover-custom" role="tooltip"><h3 class="popover-header text-white"></h3><div class="popover-body"></div></div>',
    });
    popover.show();
}

const hidePopover = (enterprise) => {
    const popover = bootstrap.Popover.getInstance(enterprise);
    if (popover) {
        popover.hide();
    }
}