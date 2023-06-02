//
//  SmallLanguageIcon.swift
//  iosApp
//
//  Created by Sahil Khan on 01/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SmallLanguageIcon: View {
    var language: UiLanguage
    var body: some View {
        Image(uiImage: UIImage(named: language.language.langName.lowercased())!)
            .resizable()
            .frame(width: 30, height: 30)
    
    }
}

