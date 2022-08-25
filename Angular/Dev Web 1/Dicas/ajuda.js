let indexOfPalavra = pub.form.situacaoPontoInspecao.descricao.indexOf(palavra);
                    let indexOfSinCausa;
                    let posSinCausaInicio;
                    let posSinCausaFim;
                    const selecionadoSinCausa = pub.sinonimosCausa.some(function (sinCausa) {
                        indexOfSinCausa = pub.form.situacaoPontoInspecao.descricao.indexOf(sinCausa);

                        posSinCausaInicio = indexOfPalavra + text.length;
                        posSinCausaFim = indexOfSinCausa + sinCausa.length; 
                        if(posSinCausaInicio >= indexOfSinCausa && posSinCausaInicio <= )
                    });